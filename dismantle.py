#!/usr/bin/env python3
from lxml import etree
import errno
import io
import os
import re
import sys
import zipfile

APP_NAME = "BachelorsAndMastersManagement"

PAGE_AUTHOR = "xwiki:XWiki.Admin"
PAGE_TIMESTAMP = "1356998400000"
PAGE_VERSION = "1.1"
XML_HEADER = u'<?xml version="1.0" encoding="UTF-8"?>\n\n'

REPO_PATH = os.path.dirname(os.path.abspath(sys.argv[0]))

def mkdir_p(path):
	try:
		os.makedirs(path)
	except OSError as exc: # Python >2.5
		if exc.errno == errno.EEXIST and os.path.isdir(path):
			pass
		else:
			raise

def remove_xwiki_tags(root):
	for element in root.findall("./object[className='XWiki.TagClass']"):
		root.remove(element)

def remove_cr(root):
	for element in root.xpath("//*"):
		if element.text is not None:
			element.text = re.sub(r"\r", "", element.text)
		for key, value in element.attrib.iteritems():
			element.attrib[key] = re.sub(r"\r", "", value)

def extract_page(xar, name):
	data = xar.read(name)
	parser = etree.XMLParser(remove_blank_text=True)
	root = etree.XML(data, parser)

	# Remove XWiki tags from page
	remove_xwiki_tags(root)

	# Remove carriage returns from text nodes
	remove_cr(root)

	# Don't collapse the defaultLanguage tag
	defaultLanguage = root.find("./defaultLanguage")
	if defaultLanguage.text is None:
		defaultLanguage.text = ""

	# Set author
	root.find("./creator").text = PAGE_AUTHOR
	root.find("./author").text = PAGE_AUTHOR
	root.find("./contentAuthor").text = PAGE_AUTHOR

	# Set timestamps
	root.find("./creationDate").text = PAGE_TIMESTAMP
	root.find("./date").text = PAGE_TIMESTAMP
	root.find("./contentUpdateDate").text = PAGE_TIMESTAMP

	# Set history information
	root.find("./version").text = "1.1"
	root.find("./comment").text = None
	root.find("./minorEdit").text = "false"

	resource = root.find("./web").text + "/" + root.find("./name").text + ".xml"
	path = REPO_PATH + "/src/main/resources/" + resource
	mkdir_p(os.path.dirname(path))
	with io.open(path, "w", newline="\r\n", encoding="utf-8") as f:
		print("Exporting " + resource + "...")
		f.write(XML_HEADER)
		f.write(etree.tostring(root, pretty_print=True, encoding="utf-8").decode("utf-8"))

def main():
	assert(os.path.isdir(REPO_PATH + "/.git"))

	with zipfile.ZipFile(sys.argv[1], "r") as xar:
		for name in xar.namelist():
			if name.startswith(APP_NAME + "/"):
				extract_page(xar, name)

if __name__ == "__main__":
    main()

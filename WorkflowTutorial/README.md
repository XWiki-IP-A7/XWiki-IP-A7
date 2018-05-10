#XWiki Peasant Guide
##Jar setup
Using [Păluș's Archeive](https://drive.google.com/file/d/171qbJabC5yGO3qu8Ug3uexm9tAi6yjHw/view?usp=sharing) which has everything already build:
Using [this guide](http://www.xwiki.org/xwiki/bin/view/Documentation/DevGuide/Tutorials/WritingComponents/):
1. Open IntelliJ
2. New Project -> Maven
3. Add Archetype
4. Insert the following data:
ArtifactId=xwiki-commons-component-archetype
GroupId=org.xwiki.commons
Version=5.4.4
5. Next...next
6. When it requires you YOUR artifact group and version use the previous ones.
7. Next...next
8. When the project is building and is getting al the dependencies press on auto enable in the bottom right corner when aven asks about imports
9. After it's done in IntelliJ go to View -> Project windows(or smth, it's the first option)-> Maven Project
10. Expand those treeViews
11. Double click on install.
12. Wait for build to finish.
13. You now have finished go in the target folder in the project and copy the jar file.
14. Paste it in XWikiHome\webapps\xwiki\WEB-INF\lib
15. Get a drink and pray for the gods that you succeded.

##Scripting
1. Open XWiki using the .bat or the .sh
2. Wait for the gods to start XWiki
3. Login as admin. User:Admin Password:admin
4. Go to your profile -> preferences
5. Press the pencil to edit.
6. Give yourself all the rights, and advanced features.
7. Go to a test page (sandbox for example)
8. Click on the dropdown on Edit -> Wiki
9. Delete that stuff.
10. Insert this new code of your own prefference:
```
{{groovy}}
println services.hello.greet()
println services.hello.dbGreet()
{{/groovy}}
```
```
{{velocity}}
$services.hello.greet()
$services.hello.dbGreet()
{{/velocity}}
```
11. Alt+S to save.
12. Hope for the best
# Sloth, a simple scaffolder
Sloth is a simple scaffolding tool, created to be used with [Backbase Portal](http://www.backbase.com/ "Backbase Portal"). Its purpose is to provide a tool for developers, to jumpstart their widget or container creation.

## Capabilities
Sloth currently supports templates for _widgets_ and _containers_. For _widgets_, there are 4 files produced, covering markup, script, styling and catalog xml. For _containers_, a jsp template is created along with its xml definition and the script and style file for the container. The templates for all these files are constructed based on [Launchpad](http://www.backbase.com/launchpad/ "Banking made beautiful") conventions, but can easily be customized for any other project.

## Usage
To use, execute the jar from the command line (make sure the templates folder is in the same location):
java -jar sloth.jar widget New Payment
java -jar sloth.jar container Springboard

A folder will be created (for example: new-payment) and all the produced files will be put there.

## Template customization
There are three variables currently available for the templates:
- {{title}} is the name of the widget/container (eg. New Payment), just as it was given in the command line.
- {{dashed}} is all-lowercase, with dashes instead of whitespace (ie. new-payment)
- {{camelCase}} is camel cased (ie. NewPayment)

## Extending
For now, to extend the current scaffolding functionality to do any of the following, you need to recomplile
- Pass a new variable to the template
- Add a new file for templating
- Add a completely new component for templating (eg. Page)

### Future plans
- Look into a proper build process and configuration, using ant.
- Remove the Widget and Container classes and stick with Scaffolder only.
- Extract the templating mechanism from Scaffolder and create a minimal templating engine
- Define components in configuration files
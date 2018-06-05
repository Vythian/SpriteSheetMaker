# SpriteSheetMaker
SpriteSheetMaker is a program that I made to automatically turn uniform sized sprites into a sprite sheet. Sprite Sheets are an image that have a bunch of images inside them. 

## Usage
### Gui:
**Coming soon**

### Command Line (Headless)
#### Step 1: Download the SpriteSheetMaker jar from the [releases page](https://github.com/Vythian/SpriteSheetMaker/releases/).
#### Step 2: Create a file called settings.json and check out the [wiki page](https://github.com/Vythian/SpriteSheetMaker/wiki/Settings-Json) for filling in the settings.  

#### Step 3: Run the jar from your command prompt or terminal. This example works for if settings.json is in the same folder as your jar, if not in the same folder then specify the path to it.
```java
java -jar SpriteSheetMaker.jar -debugMode -headless -settings settings.json
```

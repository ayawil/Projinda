# Projinda

By Aya Wilhelmson and Fredrik Blomqvist

## About

This is a project for the INDA-course at CDATE, KTH Sweden.

The program is a image processor meant to alter pictures. The supported image formats are `jpeg` and `png`. All exported images appear in the `Exports` directory.

## Instructions

The program has three different modes of which you can use it; a one-line command, a terminal interface and a GUI.

### One-line command

Execute the program with the prompt `java Program [filter] [path]` and it will export the image you've requested, to make a pixelated version of the `Skog.jpeg`-picture, simply write `java Program pixel Skog.jpeg`.

### Terminal interface

Simply run `java Program terminal` in the command prompt and the program will start in a terminal environment. In the interface you'll be able to choose the filter and path to the image which you want to apply said filter upon.

### GUI

Run `java Program` to access the GUI. Write the image path in the text field and then press `Sub...`. Press the buttons of the filters you want to apply on the image and move the slider to change the severity of the pixelization. Press `Reset` if you want to reset the image and when you're finished press the `Export`-button to export the image.
# PdfToImage
### What does it do?
PdfToImage simply extracts .jpg from within a pdf

### Requirements
- Python (only tested on 3.5)
- java
- only tested on linux

### How do I use it?
Simply download extract_image.py and PdfToImage.class and copy to the directory containing single or multiple .pdf files.
From the terminal run:
```python
python extract_images.py
```
A 4mb file with 11 A4 images takes approximately 10 sec to extract.

You can also complile the java program from with:
```javac PdfToImage.java``` 
  - Every attempt will be made to keep the compiled file up to date.

### How does it work?
The extract_image.py simply reads through its containing directory, searching for pdf files. It then runs the java class PdfToImage passing in pdf files as commandline varargs. Python creates a new directory for each pdf and the java program extracts the image, saving it to the new directory.

### Limitations
Theoretically the program can handle pdf files up to 2Gb, this has not been tested for lack of such a file.
Such a file could require upwards of 4Gb of ram.

### Todo
- potentially implement completely in python
- add some more checks to the java program
- multiprocess / thread

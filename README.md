# PdfToImage
### What does it do?
PdfToImage simply extracts .jpg from within a pdf

### Requirements
- Python (only tested on 3.5)
- java
- only tested on linux

### How do I use it?
Simply download extract_image.py and PdfToImage.class and copy to the directory containing a single or multiple .pdf files.
From the terminal run 'python extract_images.py'

### How does it work?
The python file simply read through its containing directory and looks for pdf files. It the runs the java class PdfToImage passing in the pdf files through the command line varargs. Python creates a new directory named after the pdf and the java program extracts the image from the pdf, saving it in the new directory.

### Todo
- potentially implement completely in python
- add some more checks to the java program
- multiprocess / thread

import os
"""
try:
    os.mkdir("test")
except:
    print("Output directory already exists. Please delete, rename or move it before continuing.")
"""
#os.system("cp PdfToImage.class test")

#

#os.system("rm test/PdfToImage.class")

def getExtension(string):
    if len(string.rsplit('.')) > 1:
        return string.rsplit('.')
    else:
        return ['a', 'a']

ls = os.listdir()
files = [getExtension(i) for i in ls]

pfdFiles = []
for i in files:
    if i[1] == 'pdf':
        pfdFiles.append(i)

for i in pfdFiles:
    os.mkdir(i[0])
    os.system("java PdfToImage " + "\"" +i[0] + "." + i[1] + "\"")

"""
try:
    os.mkdir("test")
except:
    print("Output directory already exists. Please delete, rename or move it before continuing.")

os.system("java PdfToImage \"test.jpg\"")
"""

"""
-> object of pdfs
-> split at pdf or take string to first .
-> mkdir with that name
-> copy java .class to folder
-> execute java
-> delete java .class

-> multiprocess
"""
"""
max theoretical filsize is probably around 2 Gb, this has not been tested.
"""

import os

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
-> object of pdfs
-> split at pdf or take string to first .
-> mkdir with that name
-> execute java
-> multiprocess

max theoretical filsize is probably around 2 Gb, this has not been tested.
"""

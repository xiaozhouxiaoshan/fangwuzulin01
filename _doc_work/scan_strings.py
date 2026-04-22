from docx import Document
from pathlib import Path
needles = ['springboot08hr3','t020','T020','zhihuifangwuzulin']
path = Path(r'D:\BaiduNetdiskDownload\T020源码\T020源码\_doc_work\thesis.docx')
doc = Document(str(path))
found = {n:0 for n in needles}
examples = {n:[] for n in needles}
for i,p in enumerate(doc.paragraphs, start=1):
    text = p.text or ''
    for n in needles:
        if n in text:
            found[n]+=1
            if len(examples[n])<5:
                examples[n].append((i,text.strip()))
print(found)
for n in needles:
    if found[n]:
        print('\n',n)
        for i,t in examples[n]:
            print(i, t[:160])

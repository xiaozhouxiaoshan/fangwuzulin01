from docx import Document
from pathlib import Path
import re
path = Path(r'D:\BaiduNetdiskDownload\T020源码\T020源码\_doc_work\thesis.docx')
doc = Document(str(path))
pat = re.compile(r'\[[0-9]+\]')
count=0
examples=[]
for i,p in enumerate(doc.paragraphs, start=1):
    t = p.text or ''
    if pat.search(t):
        count += 1
        if len(examples) < 20:
            examples.append((i, t.strip()))
print('paragraphs_with_bracket_cites', count)
for i,t in examples:
    print(i, t[:150])

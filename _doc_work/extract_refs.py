from docx import Document
from pathlib import Path

path = Path(r'D:\BaiduNetdiskDownload\T020源码\T020源码\_doc_work\thesis.docx')
doc = Document(str(path))

in_refs = False
for p in doc.paragraphs:
    text = (p.text or '').strip()
    style = p.style.name if p.style else ''
    if style.startswith('Heading') and text == '参考文献':
        in_refs = True
        continue
    if in_refs:
        if style.startswith('Heading'):
            break
        if text:
            print(text)

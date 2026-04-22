from docx import Document
from pathlib import Path

def extract(doc, heading_text, max_paras=50):
    paras = doc.paragraphs
    start=None
    for idx,p in enumerate(paras):
        if (p.text or '').strip() == heading_text and p.style and p.style.name.startswith(('Heading','标题')):
            start=idx
            break
    if start is None:
        print('NOT FOUND', heading_text)
        return
    level = int(paras[start].style.name.split()[-1]) if paras[start].style.name.startswith('Heading') else None
    out=[]
    for p in paras[start+1:]:
        style = p.style.name if p.style else ''
        if style.startswith(('Heading','标题')):
            # stop when next heading of same or higher importance
            try:
                lvl = int(style.split()[-1]) if style.startswith('Heading') else None
            except Exception:
                lvl=None
            if lvl is not None and level is not None and lvl <= level:
                break
            if style.startswith('标题') and style != '' and level is not None:
                break
        text=(p.text or '').strip()
        if text:
            out.append(text)
        if len(out) >= max_paras:
            break
    print('SECTION', heading_text)
    for t in out:
        print('-', t)

path=Path(r'D:\BaiduNetdiskDownload\T020源码\T020源码\_doc_work\thesis.docx')
doc=Document(str(path))
extract(doc,'智慧推荐模型设计')
print('---')
extract(doc,'智慧推荐功能实现')

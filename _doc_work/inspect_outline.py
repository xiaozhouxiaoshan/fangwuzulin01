from docx import Document
from pathlib import Path

def outline(path: Path, max_items=120):
    doc = Document(str(path))
    items = []
    for p in doc.paragraphs:
        style = p.style.name if p.style else ''
        text = (p.text or '').strip()
        if not text:
            continue
        if style.startswith('Heading') or style.startswith('标题'):
            items.append((style, text))
    print(path)
    print('headings', len(items))
    for style, text in items[:max_items]:
        print(f'- {style}: {text[:120]}')

if __name__ == '__main__':
    thesis = Path(r'D:\BaiduNetdiskDownload\T020源码\T020源码\_doc_work\thesis.docx')
    spec = Path(r'D:\BaiduNetdiskDownload\T020源码\T020源码\_doc_work\functional_spec.docx')
    outline(thesis)
    print('---')
    outline(spec)

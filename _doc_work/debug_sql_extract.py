from pathlib import Path


def extract_body(sql: str, table: str) -> str:
    start_pat = f"CREATE TABLE IF NOT EXISTS `{table}`"
    start = sql.find(start_pat)
    if start == -1:
        raise SystemExit("start not found")
    open_idx = sql.find("(", start)
    if open_idx == -1:
        raise SystemExit("open not found")
    i = open_idx + 1
    depth = 1
    in_str = False
    esc = False
    while i < len(sql) and depth > 0:
        ch = sql[i]
        if in_str:
            if esc:
                esc = False
            elif ch == "\\":
                esc = True
            elif ch == "'":
                in_str = False
        else:
            if ch == "'":
                in_str = True
            elif ch == "(":
                depth += 1
            elif ch == ")":
                depth -= 1
        i += 1
    if depth != 0:
        raise SystemExit("unbalanced")
    return sql[open_idx + 1 : i - 1]


def main() -> None:
    sql_path = Path(r"D:\BaiduNetdiskDownload\T020源码\T020源码\zhihuifangwuzulin.sql")
    sql = sql_path.read_text(encoding="utf-8", errors="ignore")
    body = extract_body(sql, "fangwuxinxi")
    lines = [ln.strip() for ln in body.splitlines() if ln.strip()]
    print("lines", len(lines))
    for ln in lines[:8]:
        print(repr(ln[:100]), "first_ord", ord(ln[0]))


if __name__ == "__main__":
    main()


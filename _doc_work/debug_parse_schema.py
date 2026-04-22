from pathlib import Path
import re


def main() -> None:
    sql = Path(r"D:\BaiduNetdiskDownload\T020源码\T020源码\zhihuifangwuzulin.sql").read_text(
        encoding="utf-8", errors="ignore"
    )
    start_pat = "CREATE TABLE IF NOT EXISTS `fangwuxinxi`"
    start = sql.find(start_pat)
    open_idx = sql.find("(", start)
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
    body = sql[open_idx + 1 : i - 1]
    # find first column line
    line = next(ln.strip().rstrip(",") for ln in body.splitlines() if ln.strip().startswith("`id`"))
    cm = re.match(r"`([^`]+)`\s+([^\s]+)(.*)", line)
    rest = cm.group(3)
    print("LINE:", line)
    print("REST:", rest)
    com = re.search(r"COMMENT\s+'([^']*)'", rest)
    print("COMMENT_MATCH:", com.group(1) if com else None)


if __name__ == "__main__":
    main()


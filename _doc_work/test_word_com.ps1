param()

$ErrorActionPreference = "Stop"

$w = New-Object -ComObject Word.Application
$w.Visible = $false
$v = $w.Version
$w.Quit() | Out-Null

Write-Host "WordVersion=$v"


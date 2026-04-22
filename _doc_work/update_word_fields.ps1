param(
  [Parameter(Mandatory=$true)][string]$Path
)

$ErrorActionPreference = "Stop"

if (!(Test-Path $Path)) {
  throw "File not found: $Path"
}

Write-Host "Starting Word..."
$word = New-Object -ComObject Word.Application
$word.Visible = $false
$word.DisplayAlerts = 0
Write-Host "Word started."

$doc = $null
try {
  Write-Host "Opening document..."
  $doc = $word.Documents.Open($Path)
  Write-Host "Document opened."

  # Updating all fields can be unstable in some Office installs; update TOCs only.
  Write-Host "Updating TOC..."
  foreach ($toc in $doc.TablesOfContents) { $toc.Update() | Out-Null }
  Write-Host "TOC updated."

  Write-Host "Saving..."
  $doc.Save()
  Write-Host "Saved."
} finally {
  if ($doc) {
    try { $doc.Close() | Out-Null } catch { }
  }
  if ($word) {
    try { $word.Quit() | Out-Null } catch { }
  }
  try { [System.GC]::Collect() } catch { }
  try { [System.GC]::WaitForPendingFinalizers() } catch { }
}

Write-Host "Updated fields: $Path"

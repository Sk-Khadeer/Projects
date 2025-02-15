<?php
if (!empty($_GET['file'])) {
    $filename = basename($_GET['file']);
    $filepath = 'temp/' . $filename;
    if (file_exists($filepath)) {
        header('Content-Length: ' . filesize($filepath));
        header('Content-Encoding: none');
        header('Cache-Control: public');
        header('Content-Description: File Transfer');
        header('Content-Disposition: attachment; filename="' . $filename . '"');
        header('Content-Type: ' . mime_content_type($filepath));
        header('Content-Transfer-Encoding: binary');
        readfile($filepath);
        exit;
    } else {
        echo "File not found.";
    }
}
?>
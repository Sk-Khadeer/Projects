<!DOCTYPE html>
<html>

<body>

    <?php

    //reading a file
    echo readfile("web.txt");
    echo "<br>";
    echo "<br>";
    //opening a file with fopen() function
    $myfile = fopen("web.txt", "r") or die("Unable to open file!");
    echo fread($myfile, filesize("web.txt"));
    fclose($myfile);
    echo "<br>";
    echo "<br>";
    //reading a single line
    $myfile = fopen("web.txt", "r") or die("Unable to open file!");
    echo fgets($myfile);
    fclose($myfile);

    //The fopen() function is also used to create a file. Maybe a little confusing, but in PHP,
//  a file is created using the same function used to open files.
    $myfile = fopen("newfile.txt", "w") or die("Unable to open file!");
    $txt = "Hello \n";
    fwrite($myfile, $txt);
    $txt = "Sridhar bhai\n";
    fwrite($myfile, $txt);
    fclose($myfile);
    //overwriting ---   we open our existing file "newfile.txt", and write some new data into it:
// All the existing data will be ERASED and we start with an empty file.
    $myfile = fopen("newfile.txt", "w") or die("Unable to open file!");
    $txt = "Mickey Mouse\n";
    fwrite($myfile, $txt);
    $txt = "Minnie Mouse\n";
    fwrite($myfile, $txt);
    fclose($myfile);
    // You can append data to a file by using the "a" mode. The "a" mode appends text to the end of the file, while the "w" mode overrides (and erases) the old content of the file.
// we open our existing file "newfile.txt", and append some text to it:
    
    $myfile = fopen("newfile.txt", "a") or die("Unable to open file!");
    $txt = "Donald Duck\n";
    fwrite($myfile, $txt);
    $txt = "Goofy Goof\n";
    fwrite($myfile, $txt);
    fclose($myfile);
    ?>

</body>

</html>
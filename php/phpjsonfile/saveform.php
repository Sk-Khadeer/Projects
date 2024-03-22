<!-- without saving form data in db directly saved in json file -->

<?php
if ($_POST['fullname'] != "" && $_POST['fullname'] && $_POST['fullname']) {

    //if file exuists or not
    if (file_exists('cruddata.json')) {
        //if any data alteready exists in a file getting it
        $current_data = file_get_contents('cruddata.json');
        $array_data = json_decode($current_data, true);
        //whatever data we are getting from post request(form) we are storing into an array
        $new_data = array(
            'name' => $_POST['fullname'],
            'age' => $_POST['age'],
            'city' => $_POST['city']
        );

        //we have to combine new data in old data(old file)
        $array_data = $new_data;

        //converting data into json
        $json_data = json_encode($array_data, JSON_PRETTY_PRINT);

        // we have stored json data in $json_data varaible next storng in file
        if (file_put_contents('cruddata.json', $json_data)) {
            echo "<h3>Successfully saved data in JSON FILE </h3>";
        } else {
            echo "<h3>UnSuccessfully saved data in JSON FILE </h3>";
        }
    } else {
        echo "<h3>JSON FILE not exists</h3>";
    }
} else {
    echo "<h3>All form fields are required</h3>";
}
?>
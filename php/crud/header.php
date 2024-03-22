<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Php Bootstrap Model</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <?php ?>
    <div id="main-content">
        <h2>Add New Record</h2>
        <form class="post-form" action="savedata.php" method="post">
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" />
            </div>
            <div class="form-group">
                <label>Address</label>
                <input type="text" name="address" />
            </div>
            <div class="form-group">
                <label>Class</label>
                <select name="class">
                    <option value="" selected>Select Class</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10y">10</option>

                </select>
            </div>
            <div class="form-group">
                <label>Phone</label>
                <input type="number" name="phone" />
            </div>
            <div class="input_field">
                <label style="margin-right:100px;">Gender</label>
                <input type="radio" name="gender" value="male" /> <label style="margin-left:5px;">Male</label>
                <input type="radio" name="gender" value="female" /> <label style="margin-left:5px;">Female</label>
            </div>
            <input class=" submit" type="submit" value="Save" />
        </form>
    </div>
    </div>
</body>

</html>
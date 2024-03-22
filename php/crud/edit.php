<?php include 'header.php'; ?>

<div id="main-content">
    <h2>Update Details</h2>
    <?php
    include 'config.php';
    $stu_id = $_GET['id'];
    echo $stu_id;
    $sql = "select * from student where id={$stu_id}";
    $result = mysqli_query($conn, $sql) or die("Query Unsuccessfull...");
    $num = mysqli_num_rows($result);
    if ($num > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            ?>
            <form class="post-form" action="updatedata.php" method="post">
                <div class="form-group">
                    <label>Name</label>
                    <input type="hidden" name="id" value=" <?php echo $row['id']; ?>" />
                    <input type="text" name="name" value=" <?php echo $row['name']; ?>" />
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input type="text" name="address" value=" <?php echo $row['address']; ?>" />
                </div>
                <div class="form-group">
                    <label>Class</label>
                    <?php
                    $sql1 = "select * from studentclass";
                    $result1 = mysqli_query($conn, $sql1) or die("Query Unsuccessfull...");
                    $num = mysqli_num_rows($result1);
                    if ($num > 0) {
                        echo ' <select name="class">';
                        while ($row1 = mysqli_fetch_assoc($result1)) {
                            if ($row['class'] == $row1['id']) {
                                $select = "selected";
                            } else {
                                $select = "";
                            }
                            echo "<option {$select} value='{$row1['id']}'>{$row1['class']}</option>";
                        }
                        echo '</select>';
                    }
                    ?>
                </div>

                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" name="phone" value=" <?php echo $row['phone']; ?>" />
                </div>
                <div class="input_field">
                    <label style="margin-right:100px;">Gender</label>
                    <input type="radio" name="gender" value="male" <?php if ($row['gender'] == "male") {
                        echo "checked";
                    }
                    ?>>
                    <label style="margin-left:5px;">Male</label>
                    <input type="radio" name="gender" value="female" <?php if ($row['gender'] == "female") {
                        echo "checked";
                    }
                    ?>> <label style="margin-left:5px;">Female</label>
                </div>
                <input class="submit" type="submit" value="Update" />
            </form>

            <?php
        }
    }
    ?>
</div>
</div>
</body>

</html>
<?php
include 'header.php';
?>

<div id="main">
    <div id="table-data">
    </div>
</div>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        function loadTable(page) {
            $.ajax({
                url: "pagination.php",
                type: "POST",
                data: { page_no: page },
                success: function (data) {
                    $("#table-data").html(data);
                }
            });
        }
        loadTable();
        //Pagination Code
        $(document).on("click", "#pagination a", function (e) {
            e.preventDefault();
            var page_id = $(this).attr("id");
            loadTable(page_id);
        })
    });
</script>
</body>

</html>
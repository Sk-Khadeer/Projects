var userEmail = "", selectedType = "";
const coursesData = [
    {
        name: "JAVA",
        duration1: "3 months",
        amount1: "4000",
        duration2: "6 months",
        amount2: "5000",
        courseType: "document",
        titleColor: "text-primary",
        image: "../images/java.webp",
        description: "Dive deep into the world of Java and explore the intricacies of object-oriented programming. With Java being at the forefront of most applications, it's a must-learn language for aspiring developers."
    },
    {
        name: "JAVASCRIPT",
        duration1: "3 months",
        amount1: "6000",
        duration2: "6 months",
        amount2: "11000",
        courseType: "document",
        titleColor: "text-warning",
        image: "../images/js.jpg",
        description: "Dive deep into JavaScript and discover its vast ecosystem and capabilities. From client-side scripting in browsers to server-side programming, JavaScript offers versatile solutions for web development."
    },
    {
        name: "BOOTSTRAP",
        duration1: "3 months",
        amount1: "3000",
        duration2: "6 months",
        amount2: "4500",
        courseType: "document",
        titleColor: "text-danger",
        image: "../images/bootstrap.jpg",
        description: "Discover the power and flexibility of Bootstrap, the world's most popular front-end component library. Craft responsive and visually stunning web pages with ease and efficiency."
    },
    {
        name: "PYTHON",
        duration1: "3 months",
        amount1: "4000",
        duration2: "6 months",
        amount2: "7000",
        courseType: "document",
        titleColor: "text-primary",
        image: "../images/python.jpg",
        description: "Embark on your journey with Python, the versatile programming language. From web applications to artificial intelligence, Python powers the latest technological advancements."
    },
    {
        name: "REACTJS",
        duration1: "3 months",
        amount1: "6000",
        duration2: "6 months",
        amount2: "10000",
        courseType: "document",
        titleColor: "text-info",
        image: "../images/react.png",
        description: "React is an open-source JavaScript library for building user interfaces or UI components. Embrace its component-driven architecture to build efficient single-page applications. React's virtual DOM ensures optimal rendering by updating only what's necessary."
    },
    {
        name: "NODEJS",
        duration1: "3 months",
        amount1: "4500",
        duration2: "6 months",
        amount2: "8000",
        courseType: "document",
        titleColor: "text-success",
        image: "../images/Node.js_logo.svg",
        description: "Node.js is an open-source, cross-platform, back-end JavaScript runtime environment that runs on the V8 engine and executes JavaScript code outside a web browser."
    },
    {
        name: "DEVOPS",
        duration1: "3 months",
        amount1: "8000",
        duration2: "6 months",
        amount2: "12000",
        courseType: "document",
        titleColor: "text-success",
        image: "../images/devops.jpg",
        description: "Unearth the principles of DevOps and streamline your development and operations. Embrace the cultural shift promoting collaboration between development and IT operations. Delve into the world of continuous integration, testing, and delivery to achieve faster and more reliable software releases."
    },
    {
        name: "DESIGNING",
        duration1: "3 months",
        amount1: "3000",
        duration2: "6 months",
        amount2: "5000",
        courseType: "document",
        titleColor: "text-danger",
        image: "https://source.unsplash.com/500x700/?tech,code,laptop",
        description: "Immerse yourself in the creative world of digital design. Understand the principles of aesthetics, user experience, and interactive interfaces to create captivating digital artifacts."
    },
    {
        name: "AWS",
        duration1: "3 months",
        amount1: "5000",
        duration2: "6 months",
        amount2: "8000",
        courseType: "document",
        titleColor: "text-info",
        image: "../images/aws.png",
        description: "Explore Amazon Web Services, the world's most comprehensive and broadly adopted cloud platform. Dive deep into its multitude of services and solutions."
    },
    {
        name: "AZURE",
        duration1: "3 months",
        amount1: "5000",
        duration2: "6 months",
        amount2: "8000",
        courseType: "document",
        titleColor: "text-warning",
        image: "../images/azure.png",
        description: "Dive into Microsoft's Azure, a cloud service offering over 200 services. Explore its capabilities from VMs to AI services."
    },
    {
        name: "PHP",
        duration1: "3 months",
        amount1: "2000",
        duration2: "6 months",
        amount2: "3500",
        courseType: "document",
        titleColor: "text-danger",
        image: "../images/php.png",
        description: "Get started with PHP, a server-side scripting language designed for web development but also used as a general-purpose programming language."
    },
    {
        name: "MYSQL",
        duration1: "3 months",
        amount1: "2500",
        duration2: "6 months",
        amount2: "4000",
        courseType: "document",
        titleColor: "text-info",
        image: "../images/mysql.png",
        description: "Delve into MySQL, one of the most popular relational databases, and understand its robust features and scalability."
    },
    {
        name: "JAVA",
        duration1: "3 months",
        amount1: "4000",
        duration2: "6 months",
        amount2: "5000",
        courseType: "video",
        titleColor: "text-primary",
        image: "../images/java.webp",
        description: "Dive deep into the world of Java and explore the intricacies of object-oriented programming. With Java being at the forefront of most applications, it's a must-learn language for aspiring developers."
    },
    {
        name: "JAVASCRIPT",
        duration1: "3 months",
        amount1: "6000",
        duration2: "6 months",
        amount2: "11000",
        courseType: "video",
        titleColor: "text-warning",
        image: "../images/js.jpg",
        description: "Dive deep into JavaScript and discover its vast ecosystem and capabilities. From client-side scripting in browsers to server-side programming, JavaScript offers versatile solutions for web development."
    },
    {
        name: "BOOTSTRAP",
        duration1: "3 months",
        amount1: "3000",
        duration2: "6 months",
        amount2: "4500",
        courseType: "video",
        titleColor: "text-danger",
        image: "../images/bootstrap.jpg",
        description: "Discover the power and flexibility of Bootstrap, the world's most popular front-end component library. Craft responsive and visually stunning web pages with ease and efficiency."
    },
    {
        name: "PYTHON",
        duration1: "3 months",
        amount1: "4000",
        duration2: "6 months",
        amount2: "7000",
        courseType: "video",
        titleColor: "text-primary",
        image: "../images/python.jpg",
        description: "Embark on your journey with Python, the versatile programming language. From web applications to artificial intelligence, Python powers the latest technological advancements."
    },
    {
        name: "REACTJS",
        duration1: "3 months",
        amount1: "6000",
        duration2: "6 months",
        amount2: "10000",
        courseType: "video",
        titleColor: "text-info",
        image: "../images/react.png",
        description: "React is an open-source JavaScript library for building user interfaces or UI components. Embrace its component-driven architecture to build efficient single-page applications. React's virtual DOM ensures optimal rendering by updating only what's necessary."
    },
    {
        name: "NODEJS",
        duration1: "3 months",
        amount1: "4500",
        duration2: "6 months",
        amount2: "8000",
        courseType: "video",
        titleColor: "text-success",
        image: "../images/Node.js_logo.svg",
        description: "Node.js is an open-source, cross-platform, back-end JavaScript runtime environment that runs on the V8 engine and executes JavaScript code outside a web browser."
    },
    {
        name: "DEVOPS",
        duration1: "3 months",
        amount1: "8000",
        duration2: "6 months",
        amount2: "12000",
        courseType: "video",
        titleColor: "text-success",
        image: "../images/devops.jpg",
        description: "Unearth the principles of DevOps and streamline your development and operations. Embrace the cultural shift promoting collaboration between development and IT operations. Delve into the world of continuous integration, testing, and delivery to achieve faster and more reliable software releases."
    },
    {
        name: "DESIGNING",
        duration1: "3 months",
        amount1: "3000",
        duration2: "6 months",
        amount2: "5000",
        courseType: "video",
        titleColor: "text-danger",
        image: "https://source.unsplash.com/500x700/?tech,code,laptop",
        description: "Immerse yourself in the creative world of digital design. Understand the principles of aesthetics, user experience, and interactive interfaces to create captivating digital artifacts."
    },
    {
        name: "AWS",
        duration1: "3 months",
        amount1: "5000",
        duration2: "6 months",
        amount2: "8000",
        courseType: "video",
        titleColor: "text-info",
        image: "../images/aws.png",
        description: "Explore Amazon Web Services, the world's most comprehensive and broadly adopted cloud platform. Dive deep into its multitude of services and solutions."
    },
    {
        name: "AZURE",
        duration1: "3 months",
        amount1: "5000",
        duration2: "6 months",
        amount2: "8000",
        courseType: "video",
        titleColor: "text-warning",
        image: "../images/azure.png",
        description: "Dive into Microsoft's Azure, a cloud service offering over 200 services. Explore its capabilities from VMs to AI services."
    },
    {
        name: "PHP",
        duration1: "3 months",
        amount1: "2000",
        duration2: "6 months",
        amount2: "3500",
        courseType: "video",
        titleColor: "text-danger",
        image: "../images/php.png",
        description: "Get started with PHP, a server-side scripting language designed for web development but also used as a general-purpose programming language."
    },
    {
        name: "MYSQL",
        duration1: "3 months",
        amount1: "2500",
        duration2: "6 months",
        amount2: "4000",
        courseType: "video",
        titleColor: "text-info",
        image: "../images/mysql.png",
        description: "Delve into MySQL, one of the most popular relational databases, and understand its robust features and scalability."
    }
];

$(document).ready(function () {

    userEmail = sessionStorage.getItem('userEmail');

    if (!userEmail) {
        window.location.href = '../index.html'; // Redirect if no session email
    } else {
        // Validate the user's session by checking with the backend
        $.ajax({
            url: 'http://localhost:8080/validateUser',
            method: 'POST',
            data: JSON.stringify({ email: userEmail }),
            contentType: "application/json",
            success: function (response) {
                // If successful, the user is valid, proceed to load the dashboard
              
                loadDashboard();
            },
            error: function (error) {
                console.log("Validation failed:", error);
                sessionStorage.clear();

            }
        });
    }
});

function loadDashboard() {
    // Check if the user is logged in
    if (sessionStorage.getItem('loggedIn') !== 'true') {
        window.location.href = '../index.html';
    }

    // Hide all courses initially
    $(".course").hide();

    // Fetch the user's enrolled courses and display them
    fetchEnrolledCourses();

    // Check for expired courses and refresh the list afterwards
    checkForExpiredCourses();

    // Event listeners
    $("#logoutButton").on("click", logout);
    $("#enrolledCourseContainer").on("click", ".purchase", handleCourseSelection);
    $("#courseDuration").change(updateCoursePrice);
    $(".showMoreCourses").click(showAllCourses);
    $("#buynow").click(addCourse);
    $("#searchBox").on('input', searchCourses);
    $(".showMoreCourses").click(function (e) {
        e.preventDefault();
        $("#courseTypeModal").modal('show');

    });
    //  Moved this event listener outside of this function so it doesn't bind multiple times
    $(".selectCourseType").click(function () {
        selectedType = $(this).data("type");
        $("#courseTypeModal").modal('hide');

        // Clear current courses displayed
        $("#enrolledCourseContainer").empty();

        var enrolledCourses = JSON.parse(sessionStorage.getItem('enrolledCourses') || "[]");

        // Filter the courses based on the selected type and generate HTML
        coursesData.filter(course => course.courseType === selectedType).forEach(course => {
            var isEnrolled = enrolledCourses.includes(course.name.toUpperCase());
            // var courseHtml = generateCourseHTML(course);
            var courseHtml = generateCourseHTML(course, false);

            $("#enrolledCourseContainer").append(courseHtml);

            if (isEnrolled) {
                $(".course." + course.name).find(".overlay").show();
                $(".course." + course.name).find(".enrolled-text").show();
            }
        });        
    });
}

function generateCourseHTML(course, isEnrolled) {
    const remainingDaysText = course.remainingDays ? `<span class="remaining-days">${course.remainingDays} days left</span>` : '';
    var linkText ='Purchase Now';
    let icon = '';
    if (isEnrolled) {
        if (course.courseType === 'video') {
            linkText = 'Continue Watching';
            icon = '<i class="fas fa-video fa-2x"></i> ';
        } else {
            linkText = 'Continue Reading';
            icon = '<i class="fas fa-file-alt fa-2x"></i> ';
        }
    } else {
        linkText = 'Purchase Now';
    }
    let courseHtml = `
<div class="row">
<div class="course ${course.name}" 
     data-duration1="${course.duration1}" 
     data-amount1="${course.amount1}" 
     data-duration2="${course.duration2}"
     data-amount2="${course.amount2}" 
     data-name="${course.name}" 
     data-type="${course.courseType}">
    <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
            <strong class="d-inline-block mb-2 ${course.titleColor}">${course.name}</strong>
            ${remainingDaysText}
            <h3 class="mb-0">Learn ${course.name}</h3>
            <div class="mb-1 text-muted">Nov 12</div>
            <p class="card-text mb-auto">${course.description}</p>
           
            <a href="#" class="purchase" data-course-type="${course.courseType}">${icon}${linkText}</a>

        </div>
        <div class="col-auto d-none d-lg-block">
            <img class="bd-placeholder-img" width="200" height="250" src="${course.image}" alt="" />
        </div>
        <div class="overlay" style="display: none;"></div>
        <div class="enrolled-text" style="display: none;">Already Bought</div>
    </div>
</div>
</div>`;
    return courseHtml;
}

function fetchEnrolledCourses() {
    $.ajax({
        url: 'http://localhost:8080/getUserCourses',
        method: 'GET',
        data: { email: userEmail },
        success: displayEnrolledCourses,
        error: function (error) {
            console.error("Error fetching enrolled courses:", error);
        }
    });
}

function displayEnrolledCourses(enrolledCourses) {
    $("#enrolledCourseContainer").show();
    //     // After displaying enrolled courses:
    $(".showMoreCourses").show();


    const currentDate = new Date();

    // Keep track of displayed courses to prevent duplicates
    const displayedCourses = [];
    if (enrolledCourses && enrolledCourses.length > 0) {
        // sessionStorage.setItem('enrolledCourses', JSON.stringify(enrolledCourses.map(course => course.courseName.toUpperCase())));
        sessionStorage.setItem('enrolledCourses', JSON.stringify(enrolledCourses.map(course => course.courseName.toUpperCase() + "-" + course.courseType)));
        $("#enrolledCourseContainer").empty();
        enrolledCourses.forEach(enrolledCourse => {
            const courseData = coursesData.find(course => 
                course.name.toUpperCase() === enrolledCourse.courseName.toUpperCase() &&
                course.courseType === enrolledCourse.courseType
             );
            if (courseData && !displayedCourses.includes(courseData.name.toUpperCase())) {
             
           displayedCourses.push(courseData.name.toUpperCase() + "-" + courseData.courseType);

                const endDate = new Date(enrolledCourse.purchaseDate);
                if (enrolledCourse.duration == 3) {
                    endDate.setMonth(endDate.getMonth() + 3);
                } else if (enrolledCourse.duration == 6) {
                    endDate.setMonth(endDate.getMonth() + 6);
                }

                const remainingDays = Math.ceil((endDate - currentDate) / (1000 * 60 * 60 * 24));

                if (remainingDays <= 0) {
                    // Call an API to update the course status to 'not-enrolled' or 'expired'
                    checkForExpiredCourses();
                    return;  // Do not add to the enrolled list.
                }
                courseData.remainingDays = remainingDays;  // Add remaining days to courseData

                // const courseHtml = generateCourseHTML(courseData);
                
                var courseHtml = generateCourseHTML(courseData, true);
                $("#enrolledCourseContainer").append(courseHtml);
            }
        });
        $("#messageContainer").empty();
    } else {
        $("#messageContainer").html(`
                <div class="alert alert-warning">
                    No courses are purchased.
                </div>
                <button id="buyNewCourse" class="btn btn-success">Buy Now</button>
            `);


        // When "Buy Now" is clicked
        $("#buyNewCourse").click(function () {
            $("#courseTypeModal").modal('show');
            $("#messageContainer").empty();

        });

        $(".showMoreCourses").hide();

        $(".selectCourseType").click(function () {
            selectedType = $(this).data("type");
            $("#courseTypeModal").modal('hide');
        
            // Clear current courses displayed
            $("#enrolledCourseContainer").empty();
        
            const enrolledCourses = JSON.parse(sessionStorage.getItem('enrolledCourses') || "[]");
        
            coursesData.filter(course => course.courseType === selectedType).forEach(course => {
                const isEnrolled = enrolledCourses.includes(course.name.toUpperCase() + "-" + course.courseType);
                // var courseHtml = generateCourseHTML(course);
           
                var courseHtml = generateCourseHTML(course, true);

                $("#enrolledCourseContainer").append(courseHtml);
        
                if (isEnrolled) {
                    $(".course." + course.name).find(".overlay").show();
                    $(".course." + course.name).find(".enrolled-text").show();
                }
            });
        });
        
    }
}

function checkForExpiredCourses() {
    $.ajax({
        url: 'http://localhost:8080/check-expired-courses',
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        data: JSON.stringify({
            email: userEmail
        }),
        success: fetchEnrolledCourses
    });
}

function handleCourseSelection(e) {
    e.preventDefault();
    let parentCourse = $(this).closest(".course");
    selectedCourse = parentCourse.attr('class').split(' ')[1];
    let courseName = parentCourse.data('name');
    let courseType = parentCourse.data('type');


    $('#courseNameInput').val(courseName);
    updateCoursePrice();
   
    let courseLinks = {
        "JAVA": {
            document: "https://docs.oracle.com/javase/tutorial/",
            video: "https://www.youtube.com/embed/xk4_1vDrzzo"
        },
        "JAVASCRIPT": {
            document: "https://developer.mozilla.org/en-US/docs/Web/JavaScript",
            video: "https://www.youtube.com/embed/xk4_1vDrzzo"
        },
        "BOOTSTRAP": {
            document: "https://getbootstrap.com/docs/4.4/getting-started/introduction/",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },
        "PYTHON": {
            document: "https://docs.python.org/3/",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },
        "REACTJS": {
            document: "https://reactjs.org/docs/getting-started.html",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },
        "NODEJS": {
            document: "https://nodejs.org/en/docs/",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },
        "DEVOPS": {
            document: "https://www.atlassian.com/devops",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },
        "DESIGNING": {
            document: "https://www.w3.org/standards/webdesign/",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },
        "AWS": {
            document: "https://aws.amazon.com/documentation/",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },
        "AZURE": {
            document: "https://docs.microsoft.com/en-us/azure/?product=featured",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },
        "PHP": {
            document: "https://www.php.net/manual/en/",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },
        "MYSQL": {
            document: "https://dev.mysql.com/doc/",
            video: "https://getbootstrap.com/docs/4.4/getting-started/introduction/"
        },

        "DEFAULT": {
            document: "#",
            video: "#"
        }
    };

    const enrolledCourses = JSON.parse(sessionStorage.getItem('enrolledCourses') || "[]");
        if (enrolledCourses.includes(selectedCourse + "-" + courseType)) {

        let courseUrl = courseLinks[selectedCourse]
            ? courseLinks[selectedCourse][courseType]
            : courseLinks['DEFAULT'][courseType];
        $('#contentFrame').attr('src', courseUrl);
        $('#overlay').show();  // Show the overlay (this dims the background)
        $('#contentModal').show();

    } else {
        $('#buyCourseModal').modal('show');
    }
}

function closeModal() {
    $('#contentModal').hide();
    $('#overlay').hide();
    $('#contentFrame').attr('src', ''); // Clear the iframe content
}

function updateCoursePrice() {
    let duration = $("#courseDuration").val();
    let courseClass = $('#courseNameInput').val().toUpperCase();
    let parentCourse = $('.course.' + courseClass);
    let amount = parentCourse.data('amount' + duration);
    $('#amountInput').val(amount);
}

function showAllCourses(e) {
    e.preventDefault();
    $(".selectCourseType").click(function () {
    selectedType = $(this).data("type");
    $("#courseTypeModal").modal('hide');
    $("#enrolledCourseContainer").empty();       

    const enrolledCourses = JSON.parse(sessionStorage.getItem('enrolledCourses') || "[]");  
   
    coursesData.filter(course => course.courseType === selectedType).forEach(course => {
       
        let courseHtml = generateCourseHTML(course);
        $("#enrolledCourseContainer").append(courseHtml);
    });

    // After all courses are displayed, then check if they are enrolled and overlay the "Already Bought" text
    coursesData.filter(course => course.courseType === selectedType).forEach(course => {
        const isEnrolled = enrolledCourses.includes(course.name.toUpperCase() + "-" + course.courseType);
        if (isEnrolled) {
            $(".course." + course.name).find(".overlay").show();
            $(".course." + course.name).find(".enrolled-text").show();
        }
    }); 
});
}

function addCourse() {
    const selectedCourseName = $('#courseNameInput').val();
    let selectedDuration = $('#courseDuration').val();
    const selectedAmount = $('#amountInput').val();
    if (selectedDuration == 1) selectedDuration = 3;
    else if (selectedDuration == 2) selectedDuration = 6;

    $.ajax({
        url: 'http://localhost:8080/addCourse',
        type: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        data: JSON.stringify({
            email: userEmail,
            courseName: selectedCourseName,
            duration: selectedDuration,
            courseType: selectedType,
            amount: parseFloat(selectedAmount)
        }),
        success: function (response) {
            alert("Course added successfully!");
            $('#buyCourseModal').modal('hide');
            location.reload();
            fetchEnrolledCourses(); // Refresh enrolled courses after a new purchase
            $(".showMoreCourses ").show();
        },
        error: function (error) {
            console.error("Error adding course:", error);
        }
    });
}

function searchCourses() {
    const searchTerm = $(this).val().toLowerCase();
    let found = false;

    $(".course").each(function () {
        const courseName = $(this).find("strong").text().toLowerCase();
        if (courseName.includes(searchTerm)) {
            $(this).parent().show();
            found = true;
        } else {
            $(this).parent().hide();
        }
    });

    if (found) {
        $("#notFoundMessage").hide();
    } else {
        $("#notFoundMessage").show();
    }
}

function logout() {
    sessionStorage.removeItem('userEmail');
    sessionStorage.removeItem('enrolledCourses');
    sessionStorage.removeItem('loggedIn');
    window.location.href = "../index.html";
}
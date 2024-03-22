<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

// Route::get('/', function () {
//     return view('index');
// });

//routing parameters
// Route::get('/{name?}', function ($name = null) {
//     $tagdata = "<h1> Laravel php</h1>";
//     $data = compact('name', 'tagdata');
//     return view('index')->with($data);
// });

Route::get('/', function () {
    return view('home');
});

// both routes are same 
// Route::get('/post', function () {
//     return view('post');
// });
Route::view('post', '/post'); //first argumenmt: view name and second argument is route name

Route::get('/post/first', function () {
    return view('first');
});

//named routes  we can change the route name it wont effect where we can access this link
Route::get('/test', function () {
    return view('about');
})->name('about');

//redirect -- if we store as bookmark then we change the url it wont effects the page
Route::view('/about', '/test');

//page not found 
Route::fallback(function () {
    return "<h1>page not found</h1>";
});

//grouped named routes --prefix setting
Route::prefix('post')->group(function () {
    Route::get('/first', function () {
        return view('first');
    });
    Route::get('/second', function () {
        return view('second');
    });
    Route::get('/third', function () {
        return view('third');
    });
});


//DATA json
Route::get('/json', function () {
    return view('json');
});

// we can pass data from route to view
Route::get('/users', function () {
    // return view('users', ['user' => "sridhar"]);
    //2.we can pass  variable name 
    $name = "sridhar";
    // return view('users',['user'=>$name]);
    //3.we can pass muliple values
    $city = "telangana";
    // return view('users', ['user' => $name, 'city' => $city]);

    //4.we can pass javascript array also
    // return view('users', [
    //     'user' => $name,
    //     'city' => $city,
    //     'alert' => '<script>alert("Hi")</script>'
    // ]);

    //we can pass 'with()' method
    // return view('users')
    //     ->with('user', $name)
    //     ->with('city', $city);

    // passing multiple dimensional array
    $data = [
        1 => ['name' => 'salman', 'city' => 'hyd'],
        2 => ['name' => 'sridhar', 'city' => 'hyd'],
        3 => ['name' => 'rajesh', 'city' => 'hyd'],
    ];
    return view('users', ['userdata' => $data]);
});

// displaying user id by id
// Route::get('/user/{id}', function ($id) {
//     return "<h1>User : " . $id . "</h1>";
// })->name("view.user");




// displaying user data by id
Route::get('/users/{id}', function ($id) {
    $users = getUsers();
    $user = $users[$id];
    return view('user', ['id' => $user]);
})->name("view.user");

function getUsers()
{
    return [
        1 => ['name' => 'salman', 'city' => 'hyd'],
        2 => ['name' => 'sridhar', 'city' => 'hyd'],
        3 => ['name' => 'rajesh', 'city' => 'hyd'],
    ];
}
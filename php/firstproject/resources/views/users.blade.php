<h1>Users Page </h1>

{{-- <h3>Hello {{$user}} </h3>
<h3>City: {{$city}} </h3>
<h3> {!!$alert!!} </h3> --}}

{{-- for each loop for displying multi dimensional array --}}
@foreach($userdata as $id=>$u)
<h3>{{$u['name']}}|{{$u['city']}} |
<a href={{route('view.user',$id)}}>Show</a>
</h3>

@endforeach
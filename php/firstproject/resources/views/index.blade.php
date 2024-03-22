<html>
    <body>   
          <h3> Welcome, {{$name??'user'}} </h3>
            {!!$tagdata!!}
 
            @php
            $arr=[1,2,3,4];
             @endphp
            @foreach($arr as $i)
                {{$i}}
             @endforeach           
   </body>  
</html>
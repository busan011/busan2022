var arr=['item1','item2','item3','item4'];

// for(i=0; i<arr.length; i++)
//     console.log(arr[i]);
// for(msg of arr)
//     console.log(msg);
// var result=[];
// arr.forEach(ele=>result.push(ele+'번'));

// var result=arr.map(ele=>ele+"번");

// var result=arr.filter((ele,idx)=>{
//     console.log(ele,idx);
//     return idx%2==0;
// });
// var result=arr.reduce((bef,curr,idx,target)=>{
    
//     console.log(bef,curr,idx,target);
//     return bef+","+curr;
// });

// var result= arr.find((ele,idx,target)=>{
//     console.log('find');
//     return ele=='item2';
// });

var result= arr.findIndex((ele,idx,target)=>{
    console.log('find');
    return ele=='item2';
});
console.log(arr,result);

let arr2=JSON.parse('{}');
console.log(arr2);
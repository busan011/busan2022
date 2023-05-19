// 함수
function func1(){
    console.log('func1...');
}
func1();
var func02=function(msg){
    console.log('func2...'+msg);
    return 5;
};
var result=func02('abcd');
console.log(result);
(function(){
    console.log('익명함수');
})();
// 화살표함수
var func03=()=>{console.log('func03..');};
var func03=(a,b)=>{console.log('func03..'+a+b);};
func03('ABCD');
// argument 오직 하나
var func04=msg=>{console.log('func03..'+msg);};
func04('ABCDe');
(()=>{console.log('익명함수');})();
var func05=()=>{return {};};
result=func05();

var func06=msg=>({});
result=func06('abc');
console.log(result);
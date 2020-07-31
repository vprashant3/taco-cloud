
document.onreadystatechange = function() {
    if (document.readyState === 'complete') {
        let  string = `Document Ready`;
        document.getElementById('multi-line-string').innerText = string;
    }
};

window.onload = function() {
    let  string = `Window loaded1`;
    document.getElementById('multi-line-string').innerText = string;
};

function getName(){
    let fname = document.getElementById('fname').value;
    let lname = document.getElementById('lname').value;
    document.getElementById('fullname').innerText = `${fname} ${lname}`;

}



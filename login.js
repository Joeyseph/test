const student = document.getElementById('student');
const teacher = document.getElementById('teacher');
const first_name = document.getElementById('first_name');
const last_name = document.getElementById('last_name');
const password = document.getElementById('password');
const close = document.getElementById('close');
const start = document.getElementById('start');
const modal = document.getElementById('modal');
//click any place to start



// Show modal
document.body.addEventListener("click", function(event) {
  
  event.preventDefault();
  alert('clicked');
  
} ,true);
// Hide modal
close.addEventListener('click', () => modal.classList.remove('show-modal'));


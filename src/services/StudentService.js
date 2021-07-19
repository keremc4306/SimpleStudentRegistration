import axios from 'axios';

const STUDENT_API_BASE_URL = "http://localhost:8081/api/v1/students";

class StudentService {

    getStudents(){
        return axios.get(STUDENT_API_BASE_URL);
    }

    createStudent(student){
        return axios.post(STUDENT_API_BASE_URL + '/add', student);
    }

    getStudentById(studentId){
        return axios.get(STUDENT_API_BASE_URL + '/getByIdStudents/' + studentId);
    }

    updateStudent(studentId, student){
        return axios.post(STUDENT_API_BASE_URL + '/update?id=' + studentId,  student);
    }

    deleteStudent(studentId){
        return axios.delete(STUDENT_API_BASE_URL + '/delete/' + studentId);
    }
}

export default new StudentService()
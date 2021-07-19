import React, { Component } from 'react'
import StudentService from '../services/StudentService';

class UpdateStudentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            studentName: '',
            studentSurname: '',
            mobilePhoneNumber: '',
            city: '',
            district: '',
            description: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeSurnameHandler = this.changeSurnameHandler.bind(this);
        this.changeMobilePhoneHandler = this.changeMobilePhoneHandler.bind(this);
        this.changeCityHandler = this.changeCityHandler.bind(this);
        this.changeDescriptionHandler = this.changeDescriptionHandler.bind(this);
        this.updateStudent = this.updateStudent.bind(this);
    }

    componentDidMount(){
        StudentService.getStudents(this.state.id).then( (res) =>{
            let student = res.data;
            this.setState({id: this.state.id,
                studentName: student.studentName,
                studentSurname: student.studentSurname,
                mobilePhoneNumber : student.mobilePhoneNumber,
                city : student.city,
                district : student.district,
                description : student.description,
            });
        });
    }

    updateStudent = (e) => {
        e.preventDefault();
        let student = {id: this.state.id, studentName: this.state.studentName, studentSurname: this.state.studentSurname, 
            mobilePhoneNumber: this.state.mobilePhoneNumber, city: this.state.city, 
            district: this.state.district, description: this.state.description};
        console.log('student => ' + JSON.stringify(student));
        console.log('id => ' + JSON.stringify(student.id));
        StudentService.updateStudent(student.id, student).then( res => {
            console.log(res)
            this.props.history.push('/students');
        });
    }
    
    changeNameHandler= (event) => {
        this.setState({studentName: event.target.value});
    }

    changeSurnameHandler= (event) => {
        this.setState({studentSurname: event.target.value});
    }

    changeMobilePhoneHandler= (event) => {
        this.setState({mobilePhoneNumber: event.target.value});
    }

    changeCityHandler= (event) => {
        this.setState({city: event.target.value});
    }

    changeDistrictHandler= (event) => {
        this.setState({district: event.target.value});
    }

    changeDescriptionHandler= (event) => {
        this.setState({description: event.target.value});
    }

    cancel(){
        this.props.history.push('/students');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Student</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <strong> Name: </strong>
                                            <input type = "text" name="studentName" 
                                                value={this.state.studentName} onChange={this.changeNameHandler}/>
                                        </div>
                                        <br />

                                        <div className = "form-group">
                                            <strong> Surname: </strong>
                                            <input type = "text" name="studentSurname"
                                                value={this.state.studentSurname} onChange={this.changeSurnameHandler}/>
                                        </div>
                                        <br />
                                        
                                        <div className = "form-group">
                                            <strong> Mobile phone number: </strong>
                                            <input type = "text" name="mobilePhoneNumber" 
                                                value={this.state.mobilePhoneNumber} onChange={this.changeMobilePhoneHandler}/>
                                        </div>
                                        <br />

                                        <div className = "form-group">
                                            <strong> City: </strong>
                                            <input type = "text" name="city"
                                                value={this.state.city} onChange={this.changeCityHandler}/>
                                        </div>
                                        <br />

                                        <div className = "form-group">
                                            <strong> District: </strong>
                                            <input type="text" name="district"
                                                value={this.state.district} onChange={this.changeDistrictHandler}/>
                                        </div>
                                        <br />

                                        <div className = "form-group">
                                            <strong> Description: </strong>
                                            <input type="text" name="description"
                                                value={this.state.description} onChange={this.changeDescriptionHandler}/>
                                        </div>
                                        <br />

                                        <button className="btn btn-success" onClick={this.updateStudent}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateStudentComponent
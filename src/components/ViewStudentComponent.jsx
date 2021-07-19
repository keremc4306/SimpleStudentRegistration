import React, { Component } from 'react'
import StudentService from '../services/StudentService'

class ViewStudentComponent extends Component {
    constructor(props) {
        super(props)
        console.log(props);
        this.state = {
            id: this.props.match.params.id,
            student: {}
        }
    }
   
    componentDidMount(){
        StudentService.getStudentById(this.state.id).then( res => {
            this.setState({student: res.data});
            
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Student Details</h3>
                    <div className = "card-body">
                    <div className = "row">
                            <label> <strong>Name: </strong> { this.state.student.studentName } </label>
                    </div>
                        <div className = "row">
                            <label> <strong>Surname: </strong> { this.state.student.studentSurname }</label>
                        </div>
                        <div className = "row">
                            <label> <strong>Mobile phone number: </strong> { this.state.student.mobilePhoneNumber }</label>
                        </div>
                        <div className = "row">
                            <label> <strong>City: </strong>{ this.state.student.city }</label>
                        </div>
                        <div className = "row">
                            <label> <strong>District: </strong> { this.state.student.district }</label>
                        </div>
                        <div className = "row">
                            <label> <strong>Description: </strong> { this.state.student.description }</label>
                        </div>
                        
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewStudentComponent

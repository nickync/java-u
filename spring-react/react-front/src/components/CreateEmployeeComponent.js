import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService';
import withRouter from './withRouter';

class CreateEmployeeComponent extends Component {
    constructor(props){
        super(props)

        let {id} = this.props.params;

        this.state = {
            id: id,
            firstName: '',
            lastName: '',
            emailId: ''
        }

        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.saveEmployee = this.saveEmployee.bind(this);
    }

componentDidMount(){
    if (this.state.id == -1){
        return
    } else {
        EmployeeService.getEMployeeById(this.state.id).then(res => {
            let employee = res.data;
            this.setState({
                firstName: employee.firstName,
                lastName: employee.lastName,
                emailId: employee.emailId})
        })
    }
}

changeFirstNameHandler = (event) => {
    this.setState({firstName : event.target.value})
}

changeLastNameHandler = (event) => {
    this.setState({lastName : event.target.value})
}

changeEmailHandler = (event) => {
    this.setState({emailId: event.target.value})
}

saveEmployee = (event) => {
    event.preventDefault();

    let employee = {firstName: this.state.firstName, lastName: this.state.lastName, emailId: this.state.emailId};
    
    if (this.state.id == -1 ){

        EmployeeService.createEmployee(employee).then(res => {
            const { navigate } = this.props;
            navigate('/employees')
        })
    } else {
        
        EmployeeService.updateEmployee(employee, this.state.id).then( res => {
            const { navigate } = this.props;
            navigate('/employees')
        })
    } 
}

cancel(){
    const { navigate } = this.props;

    navigate('/employees');
}

getTitle(){
    if (this.state.id == -1){
        return <h3 className='text-center'> Add Employee </h3>
    } else {
        return <h3 className='text-center'> Update Employee</h3>
    }
}

  render() {
    return (
      <div>
        <div className='container'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    {this.getTitle()}
                    <div className='card-body'>
                        <form>
                            <div className='form-group'>
                                <label>First Name</label>
                                <input placeholder='Fist Name' name='firstName' className='form-control' 
                                    value={this.state.firstName} onChange={this.changeFirstNameHandler}/>
                            </div>

                            <div className='form-group'>
                                <label>Last Name</label>
                                <input placeholder='Last Name' name='lastName' className='form-control' 
                                    value={this.state.lastName} onChange={this.changeLastNameHandler}/>
                            </div>

                            <div className='form-group'>
                                <label>Email Address:</label>
                                <input placeholder='Email Address' name='emailId' className='form-control' 
                                    value={this.state.emailId} onChange={this.changeEmailHandler}/>
                            </div>

                            <button className='btn btn-success' onClick={this.saveEmployee}>Save</button>
                            <button className='btn btn-danger' onClick={this.cancel.bind(this)} style={{marginLeft:"10px"}}>cancel</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
      </div>
    )
  }
}

export default withRouter(CreateEmployeeComponent);

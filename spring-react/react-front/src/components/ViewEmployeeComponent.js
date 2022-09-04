import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService';
import withRouter from './withRouter';

class ViewEmployeeComponent extends Component {

    constructor(props){
        super(props)

        let {id} = this.props.params;

        this.state = {
            id: id,
            employee: {}
        }
    }

    componentDidMount(){
        EmployeeService.getEMployeeById(this.state.id).then(res => {
            this.setState({employee: res.data});
        })
    }

  render() {
    return (
      <div>
        <br></br>
        <h2> View Employee Page</h2>
        <div className='card col-md-6 offset-md-3'> 
            {/* <h3 className='text-center'> View Employee Details</h3> */}
            <div className='card-body'>
                <div className='row'>
                    <label> Employee First Name: </label>
                    <div> { this.state.employee.firstName } </div>
                </div>
                <div className='row'>
                    <label> Employee Last Name: </label>
                    <div> { this.state.employee.lastName } </div>
                </div>
                <div className='row'>
                    <label> Employee Email : </label>
                    <div> { this.state.employee.emailId } </div>
                </div>
            </div>
        </div>
      </div>
    )
  }
}

export default withRouter(ViewEmployeeComponent);
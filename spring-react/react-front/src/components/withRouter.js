import { useNavigate, /* other hooks */ } from 'react-router-dom'; 
import ListEmployeeComponent from './ListEmployeeComponent';

const withRouter = ListEmployeeComponent => props => {
  const navigate = useNavigate();
  // other hooks

  return (
    <ListEmployeeComponent
      {...props}
      {...{ navigate, /* other hooks */ }}
    />
  );
};

export default withRouter;
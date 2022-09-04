import { useNavigate, useParams/* other hooks */ } from 'react-router-dom'; 
import ListEmployeeComponent from './ListEmployeeComponent';

const withRouter = ListEmployeeComponent => props => {
  const navigate = useNavigate();
  // other hooks
  const params = useParams();

  return (
    <ListEmployeeComponent
      {...props}
      {...{ navigate, params/* other hooks */ }}
    />
  );
};

export default withRouter;
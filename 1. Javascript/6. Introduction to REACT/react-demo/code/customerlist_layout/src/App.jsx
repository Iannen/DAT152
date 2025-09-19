import './index.css';
import CustomerForm from './customerform.jsx';
import CustomerList from'./customerlist.jsx';

function CustomerView() {
        return (
            <>
                <CustomerForm/>

                <CustomerList/>
            </>
        );
}

export default CustomerView;

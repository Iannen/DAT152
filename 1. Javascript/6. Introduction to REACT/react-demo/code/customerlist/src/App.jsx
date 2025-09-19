import './index.css';

import React from 'react';

import CustomerForm from './customerform.jsx';
import CustomerList from './customerlist.jsx';

function CustomerView() {
    const [customerform,setCustomerform] = React.useState(
        {
            customername: '',
            customerid: 1,
            initialid: 1
        }
    );

    const [customerlist,setCustomerlist] = React.useState([]);

    const updateForm = (change) => {
        // Create copy
        const newCustomerForm = Object.assign({},customerform);
        Object.assign(newCustomerForm,change);
        
        setCustomerform(newCustomerForm);
    };

    const addCustomer = () => {
        // Create copy
        const newCustomerlist = Array.from(customerlist);
        newCustomerlist.push({
            customerid: customerform.customerid,
            customername: customerform.customername
        });
        setCustomerlist(newCustomerlist);

        const nextId = Number(customerform.customerid)+1;
        setCustomerform({
            customername:'',
            customerid: nextId,
            initialid: nextId
        });
    };
    
    return (
        <>
            <CustomerForm customerform={customerform} updateForm={updateForm} addCustomer={addCustomer}  />
		
            <CustomerList customerlist={customerlist}/>
	</>
    );
}

export default CustomerView;

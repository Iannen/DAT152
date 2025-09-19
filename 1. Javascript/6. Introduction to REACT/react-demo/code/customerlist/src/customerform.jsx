import React from 'react';

function CustomerForm ({customerform,updateForm,addCustomer}){
    const onFormupdate = (event) => {
        const target = event.target;
        updateForm({[target.name]: target.value});
    }

    const  onAddcustomer = (event) => {
        if (customerform.customername !== "") {
            addCustomer();
        }
    }

    return (
        <form>
            <fieldset>
                <table>
                    <tbody>
                        <tr><th><label htmlFor="customerid">Unique customer id:</label></th><td><input id="customerid" name="customerid" type="number" width="3" min={customerform.initialid} value={customerform.customerid} onChange={onFormupdate}/></td></tr>
                        <tr><th><label htmlFor="customername">Customer name:</label></th><td><input id="customername" name="customername" type="text" value={customerform.customername} onChange={onFormupdate}/></td></tr>
                    </tbody>
                </table>
                <p><button type="button" onClick={onAddcustomer}>Add customer</button></p>
            </fieldset>
        </form>
    )
}

export default CustomerForm;

function CustomerList() {
    const customers = [
        {"customerid": 1, "customername":"Ole Olsen"},
        {"customerid": 2, "customername":"Anne Annesen"},
        {"customerid": 3, "customername":"Per Persen"}
    ]
    
    let customerHTML = null
    
    if (customers.length > 0) {
        const customerHTMLRows = customers.map(customer => <tr key={customer.customerid} data-identity={customer.customerid}><td>{customer.customerid}</td><td>{customer.customername}</td></tr>);
        customerHTML = 
            <table>
                <thead>
                    <tr><th>Customer id</th><th>Customer name</th></tr>
                </thead>
                <tbody>
                    {customerHTMLRows}
                </tbody>
            </table>
    }
    return (customerHTML)
}

export default CustomerList;

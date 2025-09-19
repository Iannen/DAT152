function CustomerList({customerlist}) {
    let customerHTML = null

    if (customerlist.length > 0) {
        const customerHTMLRows = customerlist.map(customer => <tr key={customer.customerid} data-identity={customer.customerid}><td>{customer.customerid}</td><td>{customer.customername}</td></tr>);
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

import { Link, useNavigate } from "react-router-dom";

function CustomerDashboard() {
  const navigate = useNavigate();

  const user = JSON.parse(localStorage.getItem("user"));

  const handleLogout = () => {
    localStorage.removeItem("user");
    navigate("/login");
  };

  return (
    <div>
      <header>
        <h1>ServiceHub</h1>

        <div>
          <span>
            Welcome, {user?.name || "Customer"}
          </span>

          <button onClick={handleLogout}>
            Logout
          </button>
        </div>
      </header>

      <main>
        <h2>Customer Dashboard</h2>

        <p>
          Find trusted service providers and request services easily.
        </p>

        <div>
          <Link to="/customer/providers">
            <button>Find Service Providers</button>
          </Link>

          <Link to="/customer/requests">
            <button>My Service Requests</button>
          </Link>

          <Link to="/customer/request-service">
            <button>Request a Service</button>
          </Link>
        </div>
      </main>
    </div>
  );
}

export default CustomerDashboard;
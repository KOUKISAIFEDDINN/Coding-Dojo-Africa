import React from 'react';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

const Header = () => {
    const { currentUser } = useSelector((state) => state.user);

    return (
        <nav className='navbar'>
            <Link to='/' className='navbar-logo'>
                EPIC
                <i className='fab fa-firstdraft' />
            </Link>
            <ul className='nav-menu'>
                <li className='nav-item'>
                    <Link to='/' className='nav-links'>
                        Home
                    </Link>
                </li>
                <li className='nav-item'>
                    <Link to='/about' className='nav-links'>
                        About
                    </Link>
                </li>
                <li className='nav-item'>
                    <Link to='/profile' className='nav-links'>
                        {currentUser ? (
                            <img
                                src={currentUser.profile_picture}
                                alt='profile'
                                className='h-7 w-7 rounded-full object-cover'
                            />
                        ) : (
                            'Login'
                        )}
                    </Link>
                </li>
            </ul>
        </nav>
    );
};

export default Header;

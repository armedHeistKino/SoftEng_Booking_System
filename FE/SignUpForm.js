import React, { useState, useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import './SignUpForm.css'; // CSS 파일을 import합니다.

const SignUpForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [name, setName] = useState('');
  const [birthdate, setBirthdate] = useState('');
  const [email, setEmail] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [passwordMismatch, setPasswordMismatch] = useState(false);
  const [showPopup, setShowPopup] = useState(false);
  const [requiredFieldsError, setRequiredFieldsError] = useState(false);
  const validPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/.test(
    password
  );
  const navigate = useNavigate();

  useEffect(() => {
    let timeoutId;
    if (showPopup) {
      timeoutId = setTimeout(() => {
        setShowPopup(false);
        navigate('/main');
      }, 5000);
    }
    return () => clearTimeout(timeoutId);
  }, [showPopup, navigate]);

  const handleSignUp = () => {
    if (!username || !password || !name || !birthdate || !phoneNumber) {
      setRequiredFieldsError(true);
      return;
    }

    if (password !== confirmPassword || !validPassword) {
      setPasswordMismatch(true);
      return;
    }

    navigate('/main');
    setShowPopup(true);
  };

  return (
    <div>
      <div className="join_membership" role="banner">
        <Link to="/main" className="h_logo">
          <h1>
            <span className="blind">SE_Project</span>
            대충 조 이름 들어감
          </h1>
        </Link>
      </div>
      <form>
        <div>
          <label htmlFor="username">아이디</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            maxLength={20}
            required
          />
          {!username && (
            <p style={{ color: 'red', fontSize: '8pt' }}>필수 정보입니다.</p>
          )}
        </div>
        <div>
          <label htmlFor="password">비밀번호</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            maxLength={20}
            minLength={8}
            required
            autoComplete="new-password"
          />
          {!password && (
            <p style={{ color: 'red', fontSize: '8pt' }}>필수 정보입니다.</p>
          )}
          {password && !validPassword && (
            <p style={{ color: 'red', fontSize: '8pt' }}>
              8-16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.
            </p>
          )}
        </div>
        <div>
          <label htmlFor="confirmPassword">비밀번호 재확인</label>
          <input
            type="password"
            id="confirmPassword"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            maxLength={20}
            minLength={8}
            required
            autoComplete="new-password"
            />
            {confirmPassword && password !== confirmPassword && (
              <p style={{ color: 'red', fontSize: '8pt' }}>
                비밀번호가 일치하지 않습니다.
              </p>
            )}
          </div>
          <div>
            <label htmlFor="name">이름</label>
            <input
              type="text"
              id="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
              maxLength={20}
              required
            />
            {!name && (
              <p style={{ color: 'red', fontSize: '8pt' }}>필수 정보입니다.</p>
            )}
          </div>
          <div>
            <label htmlFor="birthdate">생년월일</label>
            <input
              type="date"
              id="birthdate"
              value={birthdate}
              onChange={(e) => setBirthdate(e.target.value)}
              required
            />
            {!birthdate && (
              <p style={{ color: 'red', fontSize: '8pt' }}>필수 정보입니다.</p>
            )}
          </div>
          <div>
            <label htmlFor="email">E-mail (선택)</label>
            <input
              type="text"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              maxLength={50}
            />
          </div>
          <div>
            <label htmlFor="phoneNumber">전화번호</label>
            <input
              type="text"
              id="phoneNumber"
              value={phoneNumber}
              onChange={(e) => setPhoneNumber(e.target.value)}
              maxLength={11}
              required
            />
            {!phoneNumber && (
              <p style={{ color: 'red', fontSize: '8pt' }}>필수 정보입니다.</p>
            )}
          </div>
          <button type="button" onClick={handleSignUp}>
            가입하기
          </button>
          {requiredFieldsError && (
            <p style={{ color: 'red' }}>필수 정보를 입력하세요.</p>
          )}
          {passwordMismatch && (
            <p style={{ color: 'red' }}>
              
            </p>
          )}
        </form>
        {showPopup && (
          <div className="popup">
            <p>회원 가입이 완료되었습니다. 잠시 후 메인 페이지로 이동합니다.</p>
          </div>
        )}
      </div>
  );
};

export default SignUpForm;

import { render, screen } from '@testing-library/react';
import App from './App';

test('renders GitHub Repository List', () => {
  render(<App />);
  const element = screen.getByText(/GitHub Repository List/i);
  expect(element).toBeInTheDocument();
});
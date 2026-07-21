import React from 'react';
import { render, screen } from '@testing-library/react';
import CohortDetails from './CohortDetails';

const CohortData = [
    { cohortCode: 'CWE_Java_2026', startDate: '01-Jan-2026', status: 'ongoing' }
];

describe("Cohort Details Component", () => {
    test("should create the component", () => {
        const { container } = render(<CohortDetails cohort={CohortData[0]} />);
        expect(container).toBeInTheDocument();
    });

    test("should display cohort code in h3", () => {
        render(<CohortDetails cohort={CohortData[0]} />);
        const h3Element = screen.getByRole('heading', { level: 3 });
        expect(h3Element).toHaveTextContent(CohortData[0].cohortCode);
    });

    test("should display start date and status", () => {
        render(<CohortDetails cohort={CohortData[0]} />);
        expect(screen.getByText(/Start Date:/i)).toHaveTextContent('01-Jan-2026');
        expect(screen.getByText(/Status:/i)).toHaveTextContent('ongoing');
    });

    test("should always render same html", () => {
        const { asFragment } = render(<CohortDetails cohort={CohortData[0]} />);
        expect(asFragment()).toMatchSnapshot();
    });
});

FROM python:3
# Set environment variables
ENV PYTHONUNBUFFERED 1
ENV PYTHONDONTWRITEBYTECODE 1

# install dependencies
RUN apt update \
    && apt install -y gcc python3-dev curl ca-certificates wget gnupg2 default-libmysqlclient-dev build-essential

# Directory Structure
RUN mkdir -p /pydata

# Set work directory.
WORKDIR /pydata

# Copy project code.
COPY ./ /pydata/

# Install dependencies.
RUN pip install --upgrade pip
RUN pip install -r requirements.txt

CMD ["python", "main.py"]
from flask import Flask, jsonify
from solution import solution_maze
from models.maze import Maze


app = Flask(__name__)


@app.route('/generateMaze', methods=['GET'])
def generate_maze():
    width = 20
    height = 20
    start = x, y = 1, 1
    zoom = 20
    borders = 6
    end = 19, 19
    maze = Maze(width, height)
    maze.create_maze(x, y)
    maze.cells[1][0] = False
    data = solution_maze(maze.cells, start, end, zoom, borders)
    return jsonify(data)


if __name__ == '__main__':
    app.run()
from flask import Flask, jsonify, request
from solution import solution_maze
from models.maze import Maze


app = Flask(__name__)


@app.route('/generateMaze', methods=['GET'])
def generate_maze():
    # largura = int(request.args.get('largura', False))
    # altura = int(request.args.get('altura', False))
    quantidade = int(request.args.get('quantidade'), False)
    if not quantidade:
        quantidade = 10
    start = x, y = 1, 1
    zoom = 20
    borders = 6
    end_x = quantidade - 1
    end_y = quantidade - 1
    end = end_x, end_y
    maze = Maze(quantidade, quantidade)
    maze.create_maze(x, y)
    maze.cells[1][0] = False
    data = solution_maze(maze.cells, start, end, zoom, borders)
    return jsonify(data)


if __name__ == '__main__':
    app.run()
from flask import Flask, jsonify, request, send_file
from solution import solution_maze
from models.maze import Maze


app = Flask(__name__)


@app.route('/generateMaze', methods=['GET'])
def generate_maze():
    # largura = int(request.args.get('largura', False))
    # altura = int(request.args.get('altura', False))
    quantidade = request.args.get('quantidade', False)
    id_partida = request.args.get('id_partida', False)
    if quantidade:
        quantidade = int(quantidade)
    else:
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
    data = solution_maze(maze.cells, start, end, zoom, borders, id_partida)
    return jsonify(data)

@app.route('/map/<string:file_type>/<string:id_partida>', methods=['GET'])
def get_map(file_type, id_partida):
    if file_type == 'gif':
       filename = f'{id_partida}.gif'
    elif file_type == 'png':
       filename = f'{id_partida}.png'
    return send_file('/home/developer/Git/gmdiias/hackathon-minotauro/pydata/tempfolder/' + filename, mimetype='image/gif')



if __name__ == '__main__':
    app.run()

def add_pipe_signs(ids):
    return ['||' + id.strip() + '||' for id in ids]


def process_user_input():
    print("Paste the IDs (one per line), press Enter twice when you're done:")
    ids = []
    while True:
        user_input = input().strip()
        if not user_input:
            break
        ids.append(user_input)

    
    ids_with_pipe = add_pipe_signs(ids)

    for id in ids_with_pipe:
        print(id)

process_user_input() 
